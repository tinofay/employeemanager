package com.RepoTest.RepoTest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "FullTimeEmployee")
public class FullTimeEmployee extends BaseEmployee {
    @Column(name = "salary")
    private double salary;
    @Column(name = "benefits")
    private String benefits;
}
