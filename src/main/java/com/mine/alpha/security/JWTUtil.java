package com.mine.alpha.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mine.alpha.dao.UserMapper;
import com.mine.alpha.model.User;
import com.mine.alpha.service.AuthService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.provider.MD5;

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

    public static String sign(String username,String password){
        try{
            Algorithm algorithm = Algorithm.HMAC256(password);
            String token = JWT.create()
                    .withClaim("username",username)
                    .sign(algorithm);
            return token;
        }catch (Exception e){
            return null;
        }
    }
}
