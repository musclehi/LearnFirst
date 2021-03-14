package com.design.template;

public class VehicleTemplate{
    public void open() {
        System.out.println("open door");
        System.out.println("some other common methods!");
    }

    public void call(DriveCallBack driveCallBack) {
        driveCallBack.drive();
    }


}
