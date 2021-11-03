package ActivityTracker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-25T01:21:42.638116-04:00[America/Toronto]")

@Controller
@RequestMapping("${openapi.activityTracker.base-path:}")
public class RecordsApiController implements RecordsApi {

    private final RecordsApiDelegate delegate;

    public RecordsApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) RecordsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new RecordsApiDelegate() {});
    }

    @Override
    public RecordsApiDelegate getDelegate() {
        return delegate;
    }

}
