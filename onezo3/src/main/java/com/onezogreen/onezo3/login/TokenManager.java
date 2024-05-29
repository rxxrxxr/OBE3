package com.onezogreen.onezo3.login;

import com.onezogreen.onezo3.user.UserVo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

import static io.jsonwebtoken.security.Keys.hmacShaKeyFor;

@Component
public class TokenManager {

    @Value("${p3.jwt.secret}")
    private String mykey;
    //토큰 발급
    public String generateToken(UserVo uservo){
        return Jwts.builder()
                .setSubject("onezo3Token")
                .claim("email",uservo.getEmail())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*15))
                .signWith(hmacShaKeyFor(mykey.getBytes()))
                .compact();
    }
    //토큰 검증
    public Jws<Claims> validateToken(String token){
        try{
            Jws<Claims> jws=Jwts.parser()
                    .setSigningKey(hmacShaKeyFor(mykey.getBytes()))
                    .build()
                    .parseClaimsJws(token);

            System.out.println(jws);
            return jws;
        }catch (SignatureException se){
            se.printStackTrace();
            System.out.println("SignatureException="+se);
        }catch (ExpiredJwtException ee){
            ee.printStackTrace();
            System.out.println("ExpiredJwtException="+ee);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception="+e);
        }
        return null;
    }

}
