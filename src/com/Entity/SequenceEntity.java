package com.Entity;

import javax.persistence.*;

@Entity
@Table(name = "SEQUENCE", schema = "QuizPlateform", catalog = "")
public class SequenceEntity {
    private String seqName;
    private Long seqCount;

    @Id
    @Column(name = "SEQ_NAME", nullable = false, length = 50)
    public String getSeqName() {
        return seqName;
    }

    public void setSeqName(String seqName) {
        this.seqName = seqName;
    }

    @Basic
    @Column(name = "SEQ_COUNT", nullable = true, precision = 0)
    public Long getSeqCount() {
        return seqCount;
    }

    public void setSeqCount(Long seqCount) {
        this.seqCount = seqCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SequenceEntity that = (SequenceEntity) o;

        if (seqName != null ? !seqName.equals(that.seqName) : that.seqName != null) return false;
        if (seqCount != null ? !seqCount.equals(that.seqCount) : that.seqCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = seqName != null ? seqName.hashCode() : 0;
        result = 31 * result + (seqCount != null ? seqCount.hashCode() : 0);
        return result;
    }
}
