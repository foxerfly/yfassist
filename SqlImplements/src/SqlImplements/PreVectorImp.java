/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlImplements;

import PreVector.PreVectorInterface;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author EDWIN
 */
@ServiceProvider(
        service = PreVectorInterface.class)
public class PreVectorImp implements PreVectorInterface {

    private static String loginUserName = "";
    private static String loginUserDep = "";

    @Override
    public String getLoginUserName() {
        return loginUserName;
    }

    @Override
    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }

    @Override
    public String getLoginUserDep() {
        return loginUserDep;
    }

    @Override
    public void setLoginUserDep(String loginUserDep) {
        this.loginUserDep = loginUserDep;
    }

}
