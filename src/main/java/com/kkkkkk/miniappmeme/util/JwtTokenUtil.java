package com.kkkkkk.miniappmeme.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * @author jennie
 * @create 2021-09-01 20:24
 */
public class JwtTokenUtil {

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    private static final String SECRET = "bulelemonjngrgntnuh5u6u67u676nadeunmpn";
    private static final String ISS = "jennie";

    //过期时间：一个小时
    private static final long EXPIRATION = 720000L;

    //选择了记住我之后的过期时间为7天
    private static final long EXPIRATION_REMEMBER = 604800L;

    //创建Token
    public static String createToken(Long userId, boolean isRememberMe, Map<String, Object> map){
        long expiration = isRememberMe ? EXPIRATION_REMEMBER : EXPIRATION;
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .setId(userId.toString())
                .setIssuer(ISS)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 100));
        for (Map.Entry<String, Object> entry : map.entrySet()){
            jwtBuilder.claim(entry.getKey(), entry.getValue());
        }
        return jwtBuilder.compact();
    }

    //从token中获取用户名
    // public static String getUserName(String token){
    //     return getTokenBody(token).getSubject();
    // }

    //从token中获取用户id
    public static String getUserId(String token) {
        return getTokenBody(token).getId();
    }

    //是否已过期
    public static boolean isExpiration(String token){
        return  getTokenBody(token).getExpiration().before(new Date());
    }

    private static Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
