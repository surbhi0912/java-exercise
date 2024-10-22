package OtherLearnings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class DBCourseCount {
    private static final Random random;
    static {
        random = new Random(246);
    }
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/unicorndb";
        String username = "root";
        String dbPassword = "";

        String sqlQuery = "Select course_id, count(*) as count from user_goal where " +
                "status = 'Completed' group by course_id";

        String sqlQuery2 = "Select id from course where is_deleted = 0 and total_submission = 0";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, dbPassword);
            statement = connection.createStatement();

            resultSet = statement.executeQuery(sqlQuery);

//            resultSet = statement.executeQuery(sqlQuery2);

            while(resultSet.next()){


                Integer courseId = resultSet.getInt("course_id");
                Integer count = resultSet.getInt("count");

//                if(count >= 50){
//                    String sqlStatement = String.format("Update course SET total_submission = %d where id = %d;", count, courseId);
//                    System.out.println(sqlStatement);
//                }

                if(count < 50){
                    if(count > 15){
                        Random random = new Random();

                        // Generate a random number between 50 and 99
                        count = random.nextInt(49) + 50;
                    }
                    if(count <= 15){
                        Random random = new Random();

                        // Generate a random number between 50 and 60
                        count = random.nextInt(10) + 50;
                    }

                    String sqlStatement = String.format("Update course SET total_submission = %d where id = %d;", count, courseId);
                    System.out.println(sqlStatement);
                }

//                Integer id = resultSet.getInt("id");
//                Integer c = random.nextInt(10) + 50;
//
//                String sqlStatement2 = String.format("Update course SET total_submission = %d where id = %d;", c, id);
//                System.out.println(sqlStatement2);


            }
        } catch (Exception e){

        }

    }
}



