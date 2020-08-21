package vanskarner.android.communutilidades.iu.lib.retro.company1.codes;


import vanskarner.android.communutilidades.App;
import vanskarner.android.communutilidades.R;

public class Codes implements ICodes {

    private String idToString(int id){
        return App.idToString(id);
    }


    @Override
    public String getMessagesOfCodesHttp(int codigo) {
        switch (codigo) {
            case 406://Not Acceptable
                return idToString(R.string.error_406);
            case 501://Not Implemented
                return idToString(R.string.error_501);
            default:
                return idToString(R.string.error_unknown);
        }
    }
}
