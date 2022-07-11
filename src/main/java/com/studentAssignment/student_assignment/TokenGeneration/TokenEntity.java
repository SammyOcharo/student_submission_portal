package com.studentAssignment.student_assignment.TokenGeneration;

import com.studentAssignment.student_assignment.Entity.ApplicationUSerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tokens")
public class TokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long TokenId;
    @Column(nullable = false)
    private String Token;
    @Column(nullable = false)
    private LocalDateTime ConfirmedAt;
    @Column(nullable = false)
    private LocalDateTime ExpiredAt;

    @OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private ApplicationUSerEntity applicationUSerEntity;

    public TokenEntity(String token,
                       LocalDateTime confirmedAt,
                       LocalDateTime expiredAt,
                       ApplicationUSerEntity applicationUSerEntity) {
        Token = token;
        ConfirmedAt = confirmedAt;
        ExpiredAt = expiredAt;
        this.applicationUSerEntity = applicationUSerEntity;
    }
}
