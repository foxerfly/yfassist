/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlImplements;

import HibernateCFG.HibernateCFG;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author John
 */
@ServiceProvider(
        service = HibernateCFG.class)
public class HibernateCFGImp implements HibernateCFG {

    private static String defaultCFG = "Chibernate.cfg.xml";

    @Override
    public void SetconfigurationCFG(String key) {
        if (!key.equals(null) || !key.equals("")) {
            this.defaultCFG = key;
        }
    }

    @Override
    public String getconfigurationCFG() {
        return defaultCFG;

    }
}
