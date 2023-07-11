/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author balbi
 */

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class RequestUtils {

    public static boolean possuiParametrosVazios(HttpServletRequest request) {
        Enumeration<String> paramNames = request.getParameterNames();

        while (paramNames.hasMoreElements()) {
            // Pega o próximo nome de parâmetro
            String paramName = paramNames.nextElement();

            // Pega o valor do parâmetro com base no nome
            String paramValue = request.getParameter(paramName);

            // Valida se o parâmetro está vazio
            if (paramValue == null || paramValue.trim().isEmpty()) {
                return true;
            }
        }

        return false; 
    }
}
