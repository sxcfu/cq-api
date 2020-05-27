package com.podinns.cqapi.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by lib on 2019-08-08.
 */
public class JwtUtils {
    // 过期时间5分钟
    private static final long EXPIRE_TIME = 12 * 60 * 60 * 1000;

    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String loginAccount, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim(JwtConstants.LOGIN_ACCOUNT, loginAccount)
                    .build();
            verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getLoginAccount(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(JwtConstants.LOGIN_ACCOUNT).asString();
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 生成签名,5min后过期
     *
     * @param loginAccount 用户名
     * @param secret       用户的密码
     * @return 加密的token
     */
    public static String sign(String loginAccount, String secret) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带username信息
            return JWT.create()
                    .withClaim(JwtConstants.LOGIN_ACCOUNT, loginAccount)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
