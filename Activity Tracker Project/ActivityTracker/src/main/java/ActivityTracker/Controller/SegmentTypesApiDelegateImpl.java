package ActivityTracker.Controller;

import ActivityTracker.model.SegmentTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SegmentTypesApiDelegateImpl implements SegmentTypesApiDelegate {

    @Override
    public ResponseEntity<List<SegmentTypes>> getAllSegmentTypes() {

        //Insert Logic Here

        return SegmentTypesApiDelegate.super.getAllSegmentTypes();
    }
}
