package cucumber_blueprint.enums;

public enum StatusCode {

    CODE_200(200),
    CODE_201(201),
    CODE_400(400),
    CODE_401(401);

    public final int code;

    StatusCode(int code) {
        this.code = code;
    }
}
