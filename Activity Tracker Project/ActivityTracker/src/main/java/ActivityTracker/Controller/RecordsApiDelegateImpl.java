package ActivityTracker.Controller;

import ActivityTracker.model.Record;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordsApiDelegateImpl implements RecordsApiDelegate {

    @Override
    public ResponseEntity<List<Record>> getAllRecords() {

        ArrayList<Record> records = new ArrayList<>();
        Record rec = new Record();
        rec.setDate("2020-01-01");
        rec.setCalorieIdle(1400);
        rec.setLastupdated("2020-01-01");
        records.add(rec);

        return ResponseEntity.ok(records);
    }

    @Override
    public ResponseEntity<List<Record>> getRecordByDate(String date) {

        ArrayList<Record> records = new ArrayList<>();
        ArrayList<Record> records2 = new ArrayList<>();

        if (date.equals("2020-01-01")){
            Record rec = new Record();
            rec.setDate("2022-22-22");
            rec.setCalorieIdle(2000);
            rec.setLastupdated("2022-22-22");
            records.add(rec);
            return ResponseEntity.ok(records);
        }

        return ResponseEntity.ok(records2);
    }
}
