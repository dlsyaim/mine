package com.mine.alpha.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTUtil {

    public static boolean vertify(String token,String username,String password){
        try {
            Algorithm algorithm = Algorithm.HMAC256(password);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username",username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static String getUsername(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            String username = jwt.getClaim("username").asString();
            return username;
        }catch (Exception e){
            return null;
        }
    }

    public static String getType(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            String type = jwt.getClaim("type").asString();
            return type;
        }catch (Exception e){
            return null;
        }
    }

    public static String sign(String username,String password,String type){
        try{
            Algorithm algorithm = Algorithm.HMAC256(password);
            String token = JWT.create()
                    .withClaim("username",username)
                    .withClaim("type",type)
                    .sign(algorithm);
            return token;
        }catch (Exception e){
            return null;
        }
    }
}
