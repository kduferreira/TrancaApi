package io.github.kduferreira.trancaapi.trancaapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.kduferreira.trancaapi.trancaapi.domain.enums.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
public class User implements UserDetails {



    private Long id;

    private Long condominio_id;


    private String name;

    private String last_name;

    private LocalDate birth_data;

    private Users users;


    private String  document;

    private String email;

    private String password;

    private String city;

    private String unit;

    private OffsetDateTime Dt_criacao;

    @Column
    private OffsetDateTime Dt_atualizacao;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuario_perfis",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id")
    )


    private List<Perfil> perfis = new ArrayList<>();

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return perfis.stream()
                .map(perfil -> new SimpleGrantedAuthority(perfil.getNome()))
                .collect(Collectors.toList());


    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return this.password;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
