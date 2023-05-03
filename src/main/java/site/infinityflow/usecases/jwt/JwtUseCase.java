package site.infinityflow.usecases.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import site.infinityflow.entities.security.TabelaUsuariosEntity;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Service
public class JwtUseCase {

    private static final String SECRET_KEY = "655368566D597133743677397A244326462948404D635166546A576E5A723475";


    public String extractEmail(String jwtToken) {
        return extractClaims(jwtToken, Claims::getSubject);
    }

    public <T> T extractClaims(String jwtToken, Function<Claims, T> claimsResolver) {
        final Claims claims = extractClaims(jwtToken);
        return claimsResolver.apply(claims);
    }

    public String generateToken(Map<String, Object> extractClaims, TabelaUsuariosEntity tabelaUsuariosEntity){
        return Jwts.builder()
                .setClaims(extractClaims)
                .setSubject(tabelaUsuariosEntity.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateToken(TabelaUsuariosEntity tabelaUsuariosEntity){
        return generateToken(new HashMap<>(), tabelaUsuariosEntity);
    }

    public Boolean isTokenValid(String jwtToken, TabelaUsuariosEntity tabelaUsuariosEntity) {
        final String email = extractEmail(jwtToken);
        return (email.equals(tabelaUsuariosEntity.getUsername())) && !isTokenExpired(jwtToken);

    }

    private boolean isTokenExpired(String jwtToken) {
        return extractExpiration(jwtToken).before(new Date());
    }

    private Date extractExpiration(String jwtToken) {
        return extractClaims(jwtToken, Claims::getExpiration);
    }

    private Claims extractClaims(String jwtToken) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }


    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
