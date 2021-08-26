package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&username=bye&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회 - Start]");
        request.getParameterNames().asIterator()
                .forEachRemaining(parameterName -> System.out.println(parameterName + " : " + request.getParameter(parameterName)));
        System.out.println("[전체 파라미터 조회 - End]");

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        String age = request.getParameter("age");
        System.out.println("age = " + age);

        System.out.println("[중복된 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");
        for (String duplicatedUsername : usernames) {
            System.out.println("duplicatedUsername = " + duplicatedUsername);
        }

        response.getWriter().write("ok");
    }
}
