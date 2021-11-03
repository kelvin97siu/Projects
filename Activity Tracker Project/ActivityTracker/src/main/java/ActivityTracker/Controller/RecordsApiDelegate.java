package ActivityTracker.Controller;

import ActivityTracker.model.Record;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link RecordsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-25T01:21:42.638116-04:00[America/Toronto]")

public interface RecordsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /records : obtains all records
     * gets all the records
     *
     * @return Returned all records. (status code 200)
     *         or Did not work. (status code 400)
     * @see RecordsApi#getAllRecords
     */
    default ResponseEntity<List<Record>> getAllRecords() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"date\" : \"date\", \"lastupdated\" : \"lastupdated\", \"calorieIdle\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /records/{date} : Find record by date
     * Returns a single record
     *
     * @param date date of record (required)
     * @return successful operation (status code 200)
     *         or Invalid date supplied (status code 400)
     * @see RecordsApi#getRecordByDate
     */
    default ResponseEntity<List<Record>> getRecordByDate(String date) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"date\" : \"date\", \"lastupdated\" : \"lastupdated\", \"calorieIdle\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
