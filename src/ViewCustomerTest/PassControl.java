package ViewCustomerTest;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import ViewCustomerTest.Test;
import ViewCustomerTest.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PassControl implements Initializable {
	@FXML
	private TableView cuView;
	@FXML
	private TableColumn cuname;
	@FXML
	private TableColumn cuid;
	@FXML
	private TableColumn cudata;
	@FXML
	private Label deNa;;
	@FXML
	private Label deID;
	@FXML
	private Label deDa;
	@FXML
	private Label dePh;
    @FXML 
    private Button PBbutton;  //button to passbooking;
	private static Connection LoginConn = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	public void showList() throws SQLException {
		int i = 0;

		ObservableList<User> list = FXCollections.observableArrayList();
		LoginConn = connection.connectDB(); // connect to the SQL
		st = LoginConn.createStatement(); // create statement of it
		rs = st.executeQuery(
				"select * from (booking INNER JOIN Details On booking.user_id = details.user_id) INNER JOIN employee ON booking.emp_id = employee.emp_uid WHERE booking.month < 4");

		
		
		while (rs.next()) {
			User user = new User();// 构建值对象
			user.setUsername(rs.getString("FIRST_NAME") + rs.getString("EMP_FIRST"));
			user.setID(rs.getInt("USER_ID"));
			//user.setPh(rs.getInt("PHONE"));
			int dayID = rs.getInt("DAY");
			int monthID = rs.getInt("Month");
			int yearID = rs.getInt("Year");
			user.setData(dayID + "/" + monthID + "/" + yearID);
			i++;
			cuname.setCellValueFactory(new PropertyValueFactory("username"));// 映射
			cuid.setCellValueFactory(new PropertyValueFactory("ID"));
			cudata.setCellValueFactory(new PropertyValueFactory("data"));
			list.add(user); // list添加值对象
		}
		showUserDetails(list.get(0));
		


		
		//选择变化
		cuView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                showUserDetails((User) newValue);
            }
        });

		
		cuView.setItems(list); // tableview添加list
	}
    StageController myController;
    public void setStageController(StageController stageController) {
        this.myController = stageController;
    }
	
	public void goPB(){
        myController.setStage(MainApp.mainViewID);
        }
	private void showUserDetails(User User) {
		if (User != null) {
			// Fill the labels with info from the person object.
			deNa.setText(User.getUsername());
			deID.setText(Integer.toString(User.getID()));
			deDa.setText(User.getData());
		} else {
			// Person is null, remove all the text.
			deNa.setText("");
			deID.setText("");
			deDa.setText("");
		}
	}
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		try {
			showList();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}