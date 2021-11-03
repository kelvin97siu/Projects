import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Locale;

public class ParseJson {
  
  /**
   * Insert function used to create the string format for the prepared statement. 
   * Due to variations in the way the insert statement is formatted, this particular function
   * was only used for loading data into the record table via recordBulkLoading(). 
   * 
   * @param tableName the string name of the table where data is being inserted into.
   * @param colName the string array of attributes / columns associated with the table.
   * @return the insert statement needed for inserting data using prepared statements.
   */
  public static String insert(String tableName, String[] colName) {
    
    //Goal of the code below is to create a string in the following format: "INSERT INTO table_name (param1, param2, etc.) VALUES (?, ?, etc.)
    
    String head = "INSERT INTO " + tableName + " ";
    
    String col = "(";
    String end = "(";
    for (int i = 0; i < colName.length; i++) {
      col = col + colName[i] + ", ";
      end = end + "?, ";
    }
    
    col = col.trim();
    col = col.substring(0, col.length()-1);
    col = col + ") VALUES ";
    
    end = end.trim();
    end = end.substring(0, end.length()-1);
    end = end + ")";

    return head + col + end;
  }
  
  /**
   * parseArray function will parse data from a particular JSON object from the JSON file
   * and add that object into a string array. 
   * 
   * @param array the JSON file that has been converted into a JSON array.
   * @param value the String value of the desired JSON object.
   * @return String array containing all the data for a particular object / attribute.
   */
  public static ArrayList<String> parseArray(JSONArray array, String value){
    ArrayList<String> attribute = new ArrayList<String>();
   
    for (Object o: array) {
      JSONObject objects = (JSONObject) o;
      String object = String.valueOf(objects.get(value));
      attribute.add(object);
    }
    
    return attribute;
  }
  
  /**
   * Formats date into the proper date format and converts the String array of dates into the Date data type.
   * @param array the String array that contains all the dates from a date object.
   * @return an array of dates that are in the Date data type.
   */
  public static ArrayList<Date> dateConvert(ArrayList<String> array) {
    ArrayList<Date> attribute = new ArrayList<Date>();
    
    //Want to convert an array of dates from 20130209 -> 2013-02-09
    
    for (String date: array) {
      String year = date.substring(0,4);
      String month = date.substring(4,6);
      String day = date.substring(6,8);
      String dateformat = String.format("%s-%s-%s", year, month, day);
      
      Date newdate = Date.valueOf(dateformat);
      attribute.add(newdate);
    }
    
    return attribute;
  }
  
  /**
   * Formats date into the proper Time-stamp format and converts the String date into the Time-stamp data type.
   * @param date the specific date that needs to be converted
   * @return the date in the correct Time-stamp format and data type.
   */
  public static Timestamp timeStrampSingleConvert(String date) {
    
    //Want to convert a single date string from 20150402T225557Z -> 2015-04-02 22:55:57

    String year = date.substring(0,4);
    String month = date.substring(4,6);
    String day = date.substring(6,8);
    String hour = date.substring(9,11);
    String minute = date.substring(11,13);
    String sec = date.substring(13,15);
    
    String dateformat = String.format("%s-%s-%s %s:%s:%s", year, month, day, hour, minute, sec);
      
    Timestamp newdate = Timestamp.valueOf(dateformat);

    return newdate;
  }
  
  /**
   * Formats date into the proper Time-stamp format and converts the String array of dates into the Time-stamp data type.
   * @param array the String array that contains all the dates from a date object.
   * @return an array of dates that are in the Time-stamp data type.
   */
  public static ArrayList<Timestamp> timeStampConvert(ArrayList<String> array) {
    ArrayList<Timestamp> attribute = new ArrayList<Timestamp>();
    
    //Want to convert an array of date strings from 20150402T225557Z -> 2015-04-02 22:55:57
    
    for (String date: array) {
      String year = date.substring(0,4);
      String month = date.substring(4,6);
      String day = date.substring(6,8);
      String hour = date.substring(9,11);
      String minute = date.substring(11,13);
      String sec = date.substring(13,15);
      
      String dateformat = String.format("%s-%s-%s %s:%s:%s", year, month, day, hour, minute, sec);
      
      Timestamp newdate = Timestamp.valueOf(dateformat);
      attribute.add(newdate);
    }
    
    return attribute;
  }
  
  /**
   * Function used for loading data into the Records table.
   */
  public static void recordsBulkLoad() {
    JSONParser parser = new JSONParser();
    
    //try-catch block used to catch particularly null pointer errors and java.lang errors.
    try {
      
       //Loading JSON file.
      JSONArray file = (JSONArray) parser.parse(new FileReader("/Users/kelvin97siu/Desktop/NEU/Summer 2021/CS5500 - Foundations of SWE/storyline.json"));
      

      //String arrays containing each attribute/column in JSON file.
      ArrayList<String> dateA = parseArray(file, "date");
      ArrayList<String> kcalA = parseArray(file, "caloriesIdle");
      ArrayList<String> lastUpdateA = parseArray(file, "lastUpdate");
      

       //MySql database connection.
      String myUrl = "jdbc:mysql://127.0.0.1:3306/ActivityTracker";
      Connection conn = DriverManager.getConnection(myUrl, "root", "12345678$Iu");
      
      
      /*
       * Loading data into Records Table.
       */
      //Insert Statement Format.
      String[] records = {"date", "calorieIdle", "lastUpdate"};
      String query = insert("Records", records);
      
      //Convert date into Date data type.
      ArrayList<Date> dateV = dateConvert(dateA);
      
      //Convert kcalIdle into Integer data type.
      ArrayList<Integer> kcalIdleV = new ArrayList<Integer>();
      for (int i = 0; i < kcalA.size(); i++) {
        int val = Integer.valueOf(kcalA.get(i));
        kcalIdleV.add(val);
      }
      
      //Convert lastUpdate into Time-stamp data type.
      ArrayList<Timestamp> lastUpdateV = timeStampConvert(lastUpdateA);
      
      //Loading all relevant attributes to records table
      for (int i = 0; i < dateA.size(); i++) { 
        PreparedStatement prepstmt = conn.prepareStatement(query);
        prepstmt.setDate(1, dateV.get(i));
        prepstmt.setInt(2, kcalIdleV.get(i));
        prepstmt.setTimestamp(3, lastUpdateV.get(i));
        prepstmt.execute();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Function used for loading data into the Summary table.
   */
  public static void summaryBulkLoad() {
    JSONParser parser = new JSONParser();
    
    try {

       //Loading JSON file.
      JSONArray file = (JSONArray) parser.parse(new FileReader("/Users/kelvin97siu/Desktop/NEU/Summer 2021/CS5500 - Foundations of SWE/storyline.json"));
      

       //MySql database connection.
      String myUrl = "jdbc:mysql://127.0.0.1:3306/ActivityTracker";
      Connection conn = DriverManager.getConnection(myUrl, "root", "12345678$Iu");
      

      //Setting up date array
      ArrayList<String> dateA = parseArray(file, "date");
      ArrayList<Date> dateV = dateConvert(dateA);
      
       //Setting up insert statement
      String query = "INSERT INTO Summary (date) VALUES (?)";
      
      /*
       * Loading date into summary table
       */
      for (int i = 0; i < dateA.size(); i++) {
        PreparedStatement prepstmt = conn.prepareStatement(query);
        prepstmt.setDate(1, dateV.get(i));
        prepstmt.execute();
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Function used for loading data into the SegmentJoin table.
   */
  public static void segJoinBulkLoad() {
    JSONParser parser = new JSONParser();
    
    try {

       //Loading JSON file.
      JSONArray file = (JSONArray) parser.parse(new FileReader("/Users/kelvin97siu/Desktop/NEU/Summer 2021/CS5500 - Foundations of SWE/storyline.json"));
      
       //MySql database connection.
      String myUrl = "jdbc:mysql://127.0.0.1:3306/ActivityTracker";
      Connection conn = DriverManager.getConnection(myUrl, "root", "12345678$Iu");
      

      //Setting up date array
      ArrayList<String> dateA = parseArray(file, "date");
      ArrayList<Date> dateV = dateConvert(dateA);
      
      //Setting up insert statement
      String query = "INSERT INTO SegmentJoin (date) VALUES (?)";
      
      /*
       * Loading date into summary table
       */
      for (int i = 0; i < dateA.size(); i++) {
        PreparedStatement prepstmt = conn.prepareStatement(query);
        prepstmt.setDate(1, dateV.get(i));
        prepstmt.execute();
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Function used for loading activity from the summary object into the Activity table.
   */
  public static void activityBulkLoad() {
    JSONParser parser = new JSONParser();
      try {

        
        //Loading JSON file.
        JSONArray file = (JSONArray) parser.parse(new FileReader("/Users/kelvin97siu/Desktop/NEU/Summer 2021/CS5500 - Foundations of SWE/storyline.json"));

        //MySql database connection.
        String myUrl = "jdbc:mysql://127.0.0.1:3306/ActivityTracker";
        Connection conn = DriverManager.getConnection(myUrl, "root", "12345678$Iu");
        
        
        //summaryID variable is incremented for the purpose of matching activities to the correct summaries. 
        int summaryID = 1;
        
        //for-each loop used to loop through the file to find each individual object
        for (Object o : file) {
          JSONObject objects = (JSONObject) o;
          
          //if the object in the file array is summary and it's NULL, then the insert statement will be in a default format.
          //To default a value to the default value in the create statements, simply not put the parameter into the insert statement.
          if (objects.get("summary") == null) {
            String defaultstmt = "INSERT INTO Activity(summaryID) VALUES(?)";
            PreparedStatement prepstmt = conn.prepareStatement(defaultstmt);
            prepstmt.setInt(1, summaryID);
            summaryID += 1;
          }
          
          else {
            JSONArray summary = (JSONArray) objects.get("summary");
            
            //loop through each object in the summary array.
            for (Object o1 : summary) {
            
              String walkingRunningCycling = "INSERT INTO Activity(summaryID, activity, duration, distance, calories, steps) VALUES(?,?,?,?,?,?)";
              String transport = "INSERT INTO Activity(summaryID, activity, duration, distance) VALUES(?,?,?,?)";

            
              JSONObject objects1 = (JSONObject) o1;
              String activity = String.valueOf(objects1.get("activity"));
            
              //walking, running and cycling will have the same insert string format.
              if (activity.equals("walking") || activity.equals("running") || activity.equals("cycling") ) {
                
                String dur = String.valueOf((objects1.get("duration")));
                String dis = String.valueOf((objects1.get("distance")));
                String cal = String.valueOf((objects1.get("calories")));
                String step = String.valueOf((objects1.get("steps")));
                
                String act = activity;   
                Double duration = Double.valueOf(dur);
                Double distance = Double.valueOf(dis);
                Double kcal = Double.valueOf(cal);
                Integer steps = Integer.valueOf(step);

                PreparedStatement prepstmt = conn.prepareStatement(walkingRunningCycling);
                prepstmt.setInt(1, summaryID);
                prepstmt.setString(2, act);
                prepstmt.setDouble(3, duration);
                prepstmt.setDouble(4, distance);
                prepstmt.setDouble(5, kcal);
                prepstmt.setDouble(6, steps);
                prepstmt.execute();
              
              }
              else if (activity.equals("transport")) {
              
                String dur = String.valueOf((objects1.get("duration")));
                String dis = String.valueOf((objects1.get("distance")));
                
                String act = activity;   
                Double duration = Double.valueOf(dur);
                Double distance = Double.valueOf(dis);
              
                PreparedStatement prepstmt = conn.prepareStatement(transport);
                prepstmt.setInt(1, summaryID);
                prepstmt.setString(2, act);
                prepstmt.setDouble(3, duration);
                prepstmt.setDouble(4, distance);
                prepstmt.execute();  
              }
            }
            
            summaryID += 1;
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
  
  /**
   * Function used for loading data into the SegmentType table.
   */
  public static void segmentTypesBulkLoad() {
   JSONParser parser = new JSONParser();
    
    try {
      /*
       * Loading JSON file.
       */
      JSONArray file = (JSONArray) parser.parse(new FileReader("/Users/kelvin97siu/Desktop/NEU/Summer 2021/CS5500 - Foundations of SWE/storyline.json"));
      
      /*
       * MySql database connection.
       */
      String myUrl = "jdbc:mysql://127.0.0.1:3306/ActivityTracker";
      Connection conn = DriverManager.getConnection(myUrl, "root", "12345678$Iu");
      
      int segID = 1;
      
      for (Object o : file) {
        
        JSONObject objects = (JSONObject) o;
        JSONArray seg = (JSONArray) objects.get("segments");
        
        for (Object o1 : seg) {
          
          JSONObject objects1 = (JSONObject) o1;
          
          String SegmentType = String.valueOf((objects1.get("type")));
          Timestamp startTime = timeStrampSingleConvert(String.valueOf((objects1.get("startTime"))));
          Timestamp endTime = timeStrampSingleConvert(String.valueOf((objects1.get("endTime"))));
          Timestamp lastUpdate = timeStrampSingleConvert(String.valueOf((objects1.get("lastUpdate"))));
          
          String query = "INSERT INTO SegmentTypes (segmentID, SegmentType, startTime, endTime, lastUpdate) VALUES (?,?,?,?,?)";
          
          PreparedStatement prepstmt = conn.prepareStatement(query);
          prepstmt.setInt(1, segID);
          prepstmt.setString(2, SegmentType);
          prepstmt.setTimestamp(3, startTime);
          prepstmt.setTimestamp(4, endTime);
          prepstmt.setTimestamp(5, lastUpdate);
          prepstmt.execute();

        }
        segID += 1;
        
      } 
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Function used for loading data into the Place table.
   */
  public static void placeBulkLoad() {
   JSONParser parser = new JSONParser();
    
    try {
      /*
       * Loading JSON file.
       */
      JSONArray file = (JSONArray) parser.parse(new FileReader("/Users/kelvin97siu/Desktop/NEU/Summer 2021/CS5500 - Foundations of SWE/storyline.json"));
      
      /*
       * MySql database connection.
       */
      String myUrl = "jdbc:mysql://127.0.0.1:3306/ActivityTracker";
      Connection conn = DriverManager.getConnection(myUrl, "root", "12345678$Iu");

      
      int sid = 1;
      
      for (Object o : file) {
        
        JSONObject objects = (JSONObject) o;
        JSONArray seg = (JSONArray) objects.get("segments");

        for (Object o1 : seg) {
          
          JSONObject objects1 = (JSONObject) o1;
          String SegmentType = String.valueOf((objects1.get("type")));
          
          if (SegmentType.equals("place")) {

            JSONObject objects2 = (JSONObject) objects1.get("place");
            
            String query = "INSERT INTO Place (sid, placeID, name, PlaceType) VALUES (?,?,?,?)";
            
            int placeID = Integer.valueOf(String.valueOf((objects2.get("id"))));
            String name = String.valueOf((objects2.get("name")));
            String PlaceType = String.valueOf((objects2.get("type")));
            
            PreparedStatement prepstmt = conn.prepareStatement(query);
            prepstmt.setInt(1, sid);
            prepstmt.setInt(2, placeID);
            prepstmt.setString(3, name);
            prepstmt.setString(4, PlaceType);
            prepstmt.execute();
          
            sid += 1;
          } else {
            sid += 1;
            continue;
          }    
        }
      } 
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Function used for loading activity data from the segment object into the Activity table.
   */
  public static void segmentActivityBulkLoad() {
   JSONParser parser = new JSONParser();
    
    try {
      /*
       * Loading JSON file.
       */
      JSONArray file = (JSONArray) parser.parse(new FileReader("/Users/kelvin97siu/Desktop/NEU/Summer 2021/CS5500 - Foundations of SWE/storyline.json"));
      
      /*
       * MySql database connection.
       */
      String myUrl = "jdbc:mysql://127.0.0.1:3306/ActivityTracker";
      Connection conn = DriverManager.getConnection(myUrl, "root", "12345678$Iu");
      
      int sid = 1;
      
      for (Object o : file) {
        
        JSONObject objects = (JSONObject) o;
        JSONArray seg = (JSONArray) objects.get("segments");
        
        for (Object o1 : seg) {
          
          JSONObject objects1 = (JSONObject) o1;
          String type = String.valueOf(objects1.get("type"));
          
          
          if (((type.equals("place")) && ((objects1.get("activities")) != null)) || 
              ((type.equals("move")) && ((objects1.get("activities")) != null))  || 
              ((type.equals("off")) && ((objects1.get("activities")) != null))) {
            
              JSONArray act = (JSONArray) objects1.get("activities");
              
              for (Object o2: act) {
                JSONObject objects2 = (JSONObject) o2;

                String a = String.valueOf(objects2.get("activity"));
                Double dur = Double.valueOf(String.valueOf((objects2.get("duration"))));
                Double dis = Double.valueOf(String.valueOf((objects2.get("distance"))));
                
                
                
                if (((objects2.get("calories")) != null) && (((objects2.get("steps")) != null))){
                  Integer steps = Integer.valueOf(String.valueOf((objects2.get("steps"))));
                  Integer kcal = Integer.valueOf(String.valueOf((objects2.get("calories"))));
                  String query = "INSERT INTO Activity (sid, activity, duration, distance, calories, steps) VALUES(?,?,?,?,?,?)";

                  PreparedStatement prepstmt = conn.prepareStatement(query);
                  prepstmt.setInt(1, sid);
                  prepstmt.setString(2, a);
                  prepstmt.setDouble(3, dur);
                  prepstmt.setDouble(4, dis);
                  prepstmt.setInt(5, kcal);
                  prepstmt.setInt(6, steps);
                  prepstmt.execute();
                  
                  
                } 
                else if (((objects2.get("calories")) == null) && (((objects2.get("steps")) != null))) {
                  Integer steps = Integer.valueOf(String.valueOf((objects2.get("steps"))));
                  String query = "INSERT INTO Activity (sid, activity, duration, distance, steps) VALUES(?,?,?,?,?)";

                  PreparedStatement prepstmt = conn.prepareStatement(query);
                  prepstmt.setInt(1, sid);
                  prepstmt.setString(2, a);
                  prepstmt.setDouble(3, dur);
                  prepstmt.setDouble(4, dis);
                  prepstmt.setInt(5, steps);
                  prepstmt.execute();
                }
                
                else if (((objects2.get("calories")) != null) && (((objects2.get("steps")) == null))) {
                  Integer kcal = Integer.valueOf(String.valueOf((objects2.get("calories"))));
                  String query = "INSERT INTO Activity (sid, activity, duration, distance, calories) VALUES(?,?,?,?,?)";

                  PreparedStatement prepstmt = conn.prepareStatement(query);
                  prepstmt.setInt(1, sid);
                  prepstmt.setString(2, a);
                  prepstmt.setDouble(3, dur);
                  prepstmt.setDouble(4, dis);
                  prepstmt.setInt(5, kcal);
                  prepstmt.execute();
                }
            }
          }
          sid += 1;
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  /**
   * Main function used to load JSON file data into MySQL database.
   */
  public static void main(String[] args) { 
   recordsBulkLoad();
   summaryBulkLoad();
   segJoinBulkLoad();
   activityBulkLoad();
   segmentTypesBulkLoad();
   placeBulkLoad();
   segmentActivityBulkLoad();
  }
  
}
