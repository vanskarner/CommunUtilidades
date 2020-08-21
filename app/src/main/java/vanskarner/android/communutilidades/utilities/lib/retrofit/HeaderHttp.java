package vanskarner.android.communutilidades.utilities.lib.retrofit;

public class HeaderHttp {
    private String parameter;
    private String value;

    public HeaderHttp(String parameter, String value) {
        this.parameter = parameter;
        this.value = value;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HeaderHttp{" +
                "parameter='" + parameter + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
