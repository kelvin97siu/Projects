package ActivityTracker.Controller;

import ActivityTracker.model.Activity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivitiesApiDelegateImpl implements ActivitiesApiDelegate {

    @Override
    public ResponseEntity<List<Activity>> getActivitiesByDate(String date) {

        //Insert Logic Here

        return ActivitiesApiDelegate.super.getActivitiesByDate(date);
    }

    @Override
    public ResponseEntity<List<Activity>> getAllActivities() {

        //Insert Logic Here

        return ActivitiesApiDelegate.super.getAllActivities();
    }
}
