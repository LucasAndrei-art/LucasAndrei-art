package contollers;

import annotations.Inject;
import annotations.Rota;
import repositories.Repository;
import models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController {

    @Inject
    private Repository<User> userRepository;

    @Rota("/users")
    public void getAllUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.getWriter().write("Users: " + userRepository.findAll());
    }

    @Rota("/users/create")
    public void createUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        User user = new User(name);
        userRepository.save(user);
        response.getWriter().write("User created: " + name);
    }
}
