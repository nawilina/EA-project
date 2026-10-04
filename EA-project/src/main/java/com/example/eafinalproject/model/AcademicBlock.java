package com.example.eafinalproject.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AcademicBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "semester")
    private Semester semester;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "number_of_students")
    private int numOfStudents;

    @Column(name = "block_order")
    private int blockOrder;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "registration_group_id")
    private RegistrationGroup registrationGroup;

    @OneToMany(mappedBy = "block", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CourseOffering> courseOfferingList = new ArrayList<>();

    public AcademicBlock() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }

    public void setNumOfStudents(int numOfStudents) {
        this.numOfStudents = numOfStudents;
    }

    public int getBlockOrder() {
        return blockOrder;
    }

    public void setBlockOrder(int blockOrder) {
        this.blockOrder = blockOrder;
    }

    public RegistrationGroup getRegistrationGroup() {
        return registrationGroup;
    }

    public void setRegistrationGroup(RegistrationGroup registrationGroup) {
        this.registrationGroup = registrationGroup;
    }

    public List<CourseOffering> getCourseOfferingList() {
        return courseOfferingList;
    }

    public void setCourseOfferingList(List<CourseOffering> courseOfferingList) {
        this.courseOfferingList = courseOfferingList;
    }
}