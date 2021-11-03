package ActivityTracker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-25T01:21:42.638116-04:00[America/Toronto]")

@Controller
@RequestMapping("${openapi.activityTracker.base-path:}")
public class ActivitiesApiController implements ActivitiesApi {

    private final ActivitiesApiDelegate delegate;

    public ActivitiesApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) ActivitiesApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ActivitiesApiDelegate() {});
    }

    @Override
    public ActivitiesApiDelegate getDelegate() {
        return delegate;
    }

}
