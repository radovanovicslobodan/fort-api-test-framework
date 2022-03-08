package cucumber_blueprint.enums;

public enum Props {

    DRIVER_TYPE("driverType"),
    BASE_REST_URI("baseRestUri"),
    BASE_WEB_URI("baseWebUri");

    public final String prop;

    Props(String prop) {
        this.prop = prop;
    }
}
