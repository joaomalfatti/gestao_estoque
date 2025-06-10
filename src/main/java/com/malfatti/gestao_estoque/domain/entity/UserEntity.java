package com.malfatti.gestao_estoque.domain.entity;

import java.time.LocalDate;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "tbl_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @NotBlank()
    @Pattern(regexp = "\\S+", message = "O campo [username] não pode conter espaços em branco")
    private String username;

    @Length(min = 5, max = 10, message = "A [senha] deve conter entre (5) e (10) caracteres.")
    private String password;

    @Email(message = "O campo [email] deve ser um email válido")
    private String email;

    @CreationTimestamp
    private LocalDate createAt;
}
