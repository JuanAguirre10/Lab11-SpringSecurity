package com.coello.springsecuritycrud;

import com.coello.springsecuritycrud.entities.Curso;
import com.coello.springsecuritycrud.entities.Rol;
import com.coello.springsecuritycrud.entities.Usuario;
import com.coello.springsecuritycrud.persistence.ICursoDao;
import com.coello.springsecuritycrud.persistence.IRolDao;
import com.coello.springsecuritycrud.persistence.IUsuarioDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class SpringSecurityCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(IUsuarioDao usuarioDao, IRolDao rolDao, ICursoDao cursoDao, BCryptPasswordEncoder passwordEncoder) {
        return args -> {

            if (usuarioDao.count() == 0) {

                Rol rolUser = new Rol();
                rolUser.setAuthority("ROLE_USER");
                rolUser = rolDao.save(rolUser);

                Rol rolAdmin = new Rol();
                rolAdmin.setAuthority("ROLE_ADMIN");
                rolAdmin = rolDao.save(rolAdmin);

                Usuario user = new Usuario();
                user.setUsername("user");
                user.setPassword(passwordEncoder.encode("12345"));
                user.setEnabled(true);
                user.setRoles(Arrays.asList(rolUser));
                usuarioDao.save(user);

                Usuario admin = new Usuario();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("12345"));
                admin.setEnabled(true);
                admin.setRoles(Arrays.asList(rolUser, rolAdmin));
                usuarioDao.save(admin);

                System.out.println("========================================");
                System.out.println("✅ Usuarios creados exitosamente:");
                System.out.println("👤 Usuario: user | Password: 12345 | Rol: USER");
                System.out.println("👑 Usuario: admin | Password: 12345 | Roles: USER, ADMIN");
                System.out.println("========================================");
            }

            if (cursoDao.count() == 0) {
                Curso curso1 = new Curso();
                curso1.setNombre("Programmer");
                curso1.setCreditos(5);

                Curso curso2 = new Curso();
                curso2.setNombre("Developer");
                curso2.setCreditos(5);

                Curso curso3 = new Curso();
                curso3.setNombre("Expert");
                curso3.setCreditos(5);

                cursoDao.save(curso1);
                cursoDao.save(curso2);
                cursoDao.save(curso3);

                System.out.println("📚 Cursos de ejemplo creados exitosamente");
            }
        };
    }

}