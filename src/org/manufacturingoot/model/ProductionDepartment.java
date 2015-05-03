package org.manufacturingoot.model;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class ProductionDepartment extends User implements Serializable {

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the username fields are not set
        if (!(object instanceof ProductionDepartment)) {
            return false;
        }
        ProductionDepartment other = (ProductionDepartment) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.manufacturingoot.model.ProductionDepartment[ username=" + username + " ]";
    }
}
