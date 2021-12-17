package com.example.businessapibooking.config;


import com.example.businessapibooking.entity.Users;
import com.example.businessapibooking.repository.UserRepo;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable{
	private static final long serialVersionUID = -2550185165626007488L;

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Autowired private UserRepo userRepo;

    @Autowired private HttpServletRequest request;

    @Value("${jwt.secret}")
    private String secret;

    //lấy tên user ng dùng từ token
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    // lấy ngày hết hạn từ mã jwt
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

  //for retrieveing any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String token) {
    	Claims clams = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return clams;
    }

  //kiểm tra hạn của token
    public Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    //thực hiện validate token
    public Boolean validateToken(String token, UserDetails userDetails) throws ServletException, IOException {
        final Users user = getUserToToken();
        return (user.getUsername().equals(userDetails.getUsername()) &&  !isTokenExpired(token));
    }

    //convert token thành obj User


    //tạo token
    private String doGenerateToken(
    		Map<String, Object> claims, String user ) {

    	Users userEntity = userRepo.findByUsername(user);

    	Users userToken =  new Users();
    	userToken.setUsername(user);
    	userToken.setPassword(userEntity.getPassword());
    	//userToken.setUserole(userEntity.getUserole());

    	Gson gson = new Gson();
    	String userStr = gson.toJson(userToken);

        return Jwts.builder()
        		.setClaims(claims)
        		.setSubject(userStr)
        		.setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        return doGenerateToken(claims, userDetails.getUsername());
    }

    //convert token  về obj
    public Users getUserToToken() throws ServletException, IOException {
    	final String requestTokenHeader = request.getHeader("Authorization");
    	String jwtToken = requestTokenHeader.substring(7);

    	Claims clams = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwtToken).getBody();

    	String subject = clams.getSubject();
    	Gson gson = new Gson();
    	Users entity = gson.fromJson(subject, Users.class);
    	return entity;
    }

}
