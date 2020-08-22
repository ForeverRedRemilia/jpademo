package com.foreverredremilia.jpademo.entity.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "toho_residence")
public class TohoResidenceBean {
    private String residenceId; //地点主键
    private String residenceName; //地点名称
    private String residenceMaster; //地点负责人

    @Id
    @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "residence_id")
    public String getResidenceId() {
        return residenceId;
    }

    public void setResidenceId(String residenceId) {
        this.residenceId = residenceId;
    }

    @Basic
    @Column(name = "residence_name")
    public String getResidenceName() {
        return residenceName;
    }

    public void setResidenceName(String residenceName) {
        this.residenceName = residenceName;
    }

    @Basic
    @Column(name = "residence_master")
    public String getResidenceMaster() {
        return residenceMaster;
    }

    public void setResidenceMaster(String residenceMaster) {
        this.residenceMaster = residenceMaster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TohoResidenceBean that = (TohoResidenceBean) o;
        return Objects.equals(residenceId, that.residenceId) &&
                Objects.equals(residenceName, that.residenceName) &&
                Objects.equals(residenceMaster, that.residenceMaster);
    }

    @Override
    public int hashCode() {
        return Objects.hash(residenceId, residenceName, residenceMaster);
    }
}
