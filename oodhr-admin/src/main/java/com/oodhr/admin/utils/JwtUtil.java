package com.oodhr.admin.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;

/**
 * @auther Ayun
 * @date 2022/8/17 12:36
 */
public class JwtUtil {
    public static final String TOKEN_LOGIN_NAME = "loginName";
    public static final String TOKEN_LOGIN_ID = "userId";
    public static final String TOKEN_SUCCESS = "success:";
    public static final String TOKEN_FAIL = "fail:";
    /**
     * 过期时间为一天
     * TODO 正式上线更换为15分钟
     */
    private static final long EXPIRE_TIME = 24*60*60*1000;

    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "joijsdfjlsjfljfljl5135313135";

    /**
     * 生成签名,15分钟后过期
     * @param username
     * @param userId
     * @return
     */
    public static String sign(String username,String userId){
        //过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        //私钥及加密算法
        Algorithm algorithm = null;
        try {
            algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        //设置头信息
        HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        //附带username和userID生成签名
        return JWT.create().withHeader(header).withClaim(TOKEN_LOGIN_NAME,username)
                .withClaim(TOKEN_LOGIN_ID,userId).withExpiresAt(date).sign(algorithm);
    }


    public static String verity(String token){
        String result ;
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            result = jwt.getClaims().get(TOKEN_LOGIN_ID).asString();
            return result; // success:username
        } catch (IllegalArgumentException e) {
            return TOKEN_FAIL+e.getMessage();
        } catch (JWTVerificationException e) {
            return TOKEN_FAIL+e.getMessage();
        }catch (Exception e){
            return TOKEN_FAIL+e.getMessage();
        }

    }
}
