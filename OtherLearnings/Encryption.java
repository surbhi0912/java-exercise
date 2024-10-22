package OtherLearnings;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Encryption {
    private static String getEncryptedString(String auth) throws Exception {
        SecretKeySpec keyToEncrypt = getSecretKeySpec();
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keyToEncrypt);
        return Base64.getEncoder().encodeToString(cipher.doFinal(auth.getBytes("UTF-8")));
    }

    private static SecretKeySpec getSecretKeySpec() throws Exception {
        String myKey = "%%8k7h6y2a3l5i1j1a3i%n%%";
        byte[] key = myKey.getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16);
        return new SecretKeySpec(key, "AES");
    }

    public static String decrypt(String strToDecrypt) throws Exception {
        SecretKeySpec keyToDecrypt = getSecretKeySpec();
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, keyToDecrypt);
        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));

    }

    public static void main(String[] args) {
        // Database connection parameters
        //String url = "jdbc:unicorn://localhost:5432/mydatabase";
        String url = "jdbc:mysql://localhost:3306/unicorndb";
        String username = "root";
        String dbPassword = "";

        // SQL query to retrieve password from the user table
        String sqlQuery = "SELECT id, password FROM user";

        // JDBC connection and statement objects
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish the database connection
            connection = DriverManager.getConnection(url, username, dbPassword);

            // Create the JDBC statement
            statement = connection.createStatement();

            // Execute the SQL query
            resultSet = statement.executeQuery(sqlQuery);

            // Process the result set
            while (resultSet.next()) {
                String password = resultSet.getString("password");
                //System.out.println("Password: " + password);
                String encryptedPassword = getEncryptedString(password);

                // Generate SQL statement
                int userId = resultSet.getInt("id"); // Replace with the actual user ID
                String sqlStatement = String.format("UPDATE user SET password = '%s' WHERE id = %d;", encryptedPassword, userId);

                // Print the SQL statement
                System.out.println(sqlStatement);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the JDBC objects in the reverse order of their creation
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    /*public static void main(String[] args) {
        String password = "Djrocks@2602";
        try {
            String encryptedPassword = getEncryptedString(password);
            System.out.println(encryptedPassword);
            String decryptedPassword = decrypt(encryptedPassword);
            System.out.println(decryptedPassword);
        } catch(Exception e){
            e.printStackTrace();
        }

    }*/
    }
}
