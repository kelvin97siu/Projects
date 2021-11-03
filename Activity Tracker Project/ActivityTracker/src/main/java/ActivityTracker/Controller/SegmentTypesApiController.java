package ActivityTracker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-25T01:21:42.638116-04:00[America/Toronto]")

@Controller
@RequestMapping("${openapi.activityTracker.base-path:}")
public class SegmentTypesApiController implements SegmentTypesApi {

    private final SegmentTypesApiDelegate delegate;

    public SegmentTypesApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) SegmentTypesApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new SegmentTypesApiDelegate() {});
    }

    @Override
    public SegmentTypesApiDelegate getDelegate() {
        return delegate;
    }

}
