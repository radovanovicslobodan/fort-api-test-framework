package fort_blueprint.pojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Clinician {
    String id;
    String firstName;
    String lastName;
    String profession;
    String specialities;
    String shortDescription;
    String longDescription;
    String videoUrl;
    String videoThumbnailUrl;
    String profilePictureUrl;
}
