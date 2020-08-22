package com.foreverredremilia.jpademo.entity.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "toho_residence")
public class ResidenceJoinBean {
    private String residenceId; //地点主键
    private String residenceName; //地点名称

    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResidenceJoinBean that = (ResidenceJoinBean) o;
        return Objects.equals(residenceId, that.residenceId) &&
                Objects.equals(residenceName, that.residenceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(residenceId, residenceName);
    }
}
