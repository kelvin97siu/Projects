package ActivityTracker.Controller;

import ActivityTracker.model.Activity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link ActivitiesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-25T01:21:42.638116-04:00[America/Toronto]")

public interface ActivitiesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /activities/{date} : Find activities summary by date
     * Returns activities summary
     *
     * @param date date of record (required)
     * @return successful operation (status code 200)
     *         or Invalid date supplied (status code 400)
     * @see ActivitiesApi#getActivitiesByDate
     */
    default ResponseEntity<List<Activity>> getActivitiesByDate(String date) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"duration\" : 0.8008281904610115, \"activity\" : \"activity\", \"distance\" : 6.027456183070403, \"startTime\" : \"startTime\", \"endTime\" : \"endTime\", \"calories\" : 1.4658129805029452, \"steps\" : 5 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /activities : obtains all activities
     * gets all the activities
     *
     * @return Returned all activities (status code 200)
     *         or Did not work. (status code 400)
     * @see ActivitiesApi#getAllActivities
     */
    default ResponseEntity<List<Activity>> getAllActivities() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"duration\" : 0.8008281904610115, \"activity\" : \"activity\", \"distance\" : 6.027456183070403, \"startTime\" : \"startTime\", \"endTime\" : \"endTime\", \"calories\" : 1.4658129805029452, \"steps\" : 5 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
