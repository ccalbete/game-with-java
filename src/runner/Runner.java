/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runner;

import domain.Company;
import view.WindowMainMenu;

public class Runner {

    public static void main(String[] args) {
        Company company = new Company();
        /*the window containing the main program menu is displayed
         */
        WindowMainMenu window = new WindowMainMenu(company);
        window.setVisible(true);
    }
}
