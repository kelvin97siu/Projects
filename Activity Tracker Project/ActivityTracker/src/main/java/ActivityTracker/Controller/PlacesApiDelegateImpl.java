package ActivityTracker.Controller;

import ActivityTracker.model.Places;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacesApiDelegateImpl implements PlacesApiDelegate {

    @Override
    public ResponseEntity<List<Places>> getAllPlaces() {

        //Insert Logic Here

        return PlacesApiDelegate.super.getAllPlaces();
    }
}
