
public class DataConstants {
    DataConstants dataConstants;
    String[] userData;
    String[] rUData;
    String[] counselorData;
    String[] campData;
    String[] groupData;
    String[] childData;
    String[] activityData;

    private DataConstants(){
        this.setUserData();
        this.setrUData();
        this.setCounselorData();
        this.setCampData();
        this.setGroupData();
        this.setChildData();
        this.setActivityData();
    }

    private DataConstants getInstance(){
        if(this.dataConstants == null){
            this.dataConstants = new DataConstants();
        }
        return this.dataConstants;
    }

    private void setUserData(){

    }

    private void setrUData(){

    }

    private void setCounselorData(){

    }

    private void setCampData(){

    }

    private void setGroupData(){

    }

    private void setChildData(){

    }

    private void setActivityData(){

    }

}
