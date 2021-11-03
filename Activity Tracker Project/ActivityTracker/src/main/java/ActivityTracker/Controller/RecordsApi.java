/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.2.3).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package ActivityTracker.Controller;

import ActivityTracker.model.Record;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-25T01:21:42.638116-04:00[America/Toronto]")

@Validated
@Api(value = "records", description = "the records API")
public interface RecordsApi {

    default RecordsApiDelegate getDelegate() {
        return new RecordsApiDelegate() {};
    }

    /**
     * GET /records : obtains all records
     * gets all the records
     *
     * @return Returned all records. (status code 200)
     *         or Did not work. (status code 400)
     */
    @ApiOperation(value = "obtains all records", nickname = "getAllRecords", notes = "gets all the records", response = Record.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Returned all records.", response = Record.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Did not work.") })
    @RequestMapping(value = "/records",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Record>> getAllRecords() {
        return getDelegate().getAllRecords();
    }


    /**
     * GET /records/{date} : Find record by date
     * Returns a single record
     *
     * @param date date of record (required)
     * @return successful operation (status code 200)
     *         or Invalid date supplied (status code 400)
     */
    @ApiOperation(value = "Find record by date", nickname = "getRecordByDate", notes = "Returns a single record", response = Record.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Record.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid date supplied") })
    @RequestMapping(value = "/records/{date}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Record>> getRecordByDate(@ApiParam(value = "date of record",required=true) @PathVariable("date") String date) {
        return getDelegate().getRecordByDate(date);
    }

}