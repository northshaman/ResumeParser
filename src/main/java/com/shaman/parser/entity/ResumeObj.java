package com.shaman.parser.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Simplified Resume object entity
 */
@Entity
@Table(name = "resume")
public class ResumeObj {
        @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment",strategy = "increment")
    private long id;

        @Column(name = "idOriginal",nullable = false)
    private long idOriginal;

        @Column(name = "fio", nullable = false)
    private String fio;

        @Column(name = "age")
    private int age;

        @Column(name = "resumeLink")
    private String resumeLink;

        @Column(name = "positionName")
    private String positionName;

        @Column(name = "lastVisit")
    private String lastVisit;

        @Column(name = "city")
    private String city;

        @Column(name = "wageLevel")
    private String wageLevel;

        @Column(name = "education")
    private String education;

        @Column(name = "experience")
    private String experience;

        @Column(name = "lastPlaceOfWork")
    private String lastPlaceOfWork;

        @Column(name = "lastPositionName")
    private String lastPositionName;

        @Column(name = "lastPlaceDuration")
    private String lastPlaceDuration;

        @Column(name = "pictureLink")
    private String pictureLink;

    public ResumeObj() {
    }

    @Override
    public String toString() {
        return "ResumeItem{" + "\n" +
                "id=" + id + "\n" +
                "idOriginal=" + idOriginal + "\n" +
                "fio='" + fio + '\'' + "\n" +
                "age=" + age + "\n" +
                "resumeLink='" + resumeLink + '\'' + "\n" +
                "positionName='" + positionName + '\'' + "\n" +
                "lastVisit='" + lastVisit + '\'' + "\n" +
                "city='" + city + '\'' + "\n" +
                "wageLevel='" + wageLevel + '\'' + "\n" +
                "education='" + education + '\'' + "\n" +
                "experience='" + experience + '\'' + "\n" +
                "lastPlaceOfWork='" + lastPlaceOfWork + '\'' + "\n" +
                "lastPositionName='" + lastPositionName + '\'' + "\n" +
                "lastPlaceDuration='" + lastPlaceDuration + '\'' + "\n" +
                "pictureLink='" + pictureLink + '\'' + "\n" +
                '}' + "\n";
    }


    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idOriginal ^ (idOriginal >>> 32));
        result = 31 * result + fio.hashCode();
        result = 31 * result + age;
        result = 31 * result + resumeLink.hashCode();
        result = 31 * result + positionName.hashCode();
        result = 31 * result + (lastVisit != null ? lastVisit.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + wageLevel.hashCode();
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (experience != null ? experience.hashCode() : 0);
        result = 31 * result + (lastPlaceOfWork != null ? lastPlaceOfWork.hashCode() : 0);
        result = 31 * result + (lastPositionName != null ? lastPositionName.hashCode() : 0);
        result = 31 * result + (lastPlaceDuration != null ? lastPlaceDuration.hashCode() : 0);
        result = 31 * result + (pictureLink != null ? pictureLink.hashCode() : 0);
        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResumeObj that = (ResumeObj) o;

        if (id != that.id) return false;
        if (idOriginal != that.idOriginal) return false;
        if (age != that.age) return false;
        if (wageLevel != that.wageLevel) return false;
        if (!fio.equals(that.fio)) return false;
        if (!resumeLink.equals(that.resumeLink)) return false;
        if (!positionName.equals(that.positionName)) return false;
        if (lastVisit != null ? !lastVisit.equals(that.lastVisit) : that.lastVisit != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (education != null ? !education.equals(that.education) : that.education != null) return false;
        if (experience != null ? !experience.equals(that.experience) : that.experience != null) return false;
        if (lastPlaceOfWork != null ? !lastPlaceOfWork.equals(that.lastPlaceOfWork) : that.lastPlaceOfWork != null)
            return false;
        if (lastPositionName != null ? !lastPositionName.equals(that.lastPositionName) : that.lastPositionName != null)
            return false;
        if (lastPlaceDuration != null ? !lastPlaceDuration.equals(that.lastPlaceDuration) : that.lastPlaceDuration != null)
            return false;
        return pictureLink != null ? pictureLink.equals(that.pictureLink) : that.pictureLink == null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdOriginal() {
        return idOriginal;
    }

    public void setIdOriginal(long idOriginal) {
        this.idOriginal = idOriginal;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getResumeLink() {
        return resumeLink;
    }

    public void setResumeLink(String resumeLink) {
        this.resumeLink = resumeLink;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(String lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWageLevel() {
        return wageLevel;
    }

    public void setWageLevel(String wageLevel) {
        this.wageLevel = wageLevel;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLastPlaceOfWork() {
        return lastPlaceOfWork;
    }

    public void setLastPlaceOfWork(String lastPlaceOfWork) {
        this.lastPlaceOfWork = lastPlaceOfWork;
    }

    public String getLastPositionName() {
        return lastPositionName;
    }

    public void setLastPositionName(String lastPositionName) {
        this.lastPositionName = lastPositionName;
    }

    public String getLastPlaceDuration() {
        return lastPlaceDuration;
    }

    public void setLastPlaceDuration(String lastPlaceDuration) {
        this.lastPlaceDuration = lastPlaceDuration;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }
}