import React, { Component } from "react";

class ClassInfo extends Component {
  constructor(props) {
    super(props);
    this.state = {
      // handleAdd parameter
      SubjectNameCI: "",
      DayOfTheWeekCI: "",
      StartAtPeriodCI: "",
      EndAtPeriodCI: "",
    };
  }

  render() {
    let listClass = this.props.listClass;

    console.log("listClassV2 nhận được: ", listClass);

    // let handleAdd = (SubjectName, DayOfTheWeek, StartAtPeriod, EndAtPeriod) => {
    //   this.setState({
    //     SubjectNameCI: SubjectName,
    //     DayOfTheWeekCI: DayOfTheWeek,
    //     StartAtPeriodCI: StartAtPeriod,
    //     EndAtPeriodCI: EndAtPeriod,
    //   });
    //   let SN = this.state.SubjectNameCI;
    //   let DOTW = this.state.DayOfTheWeekCI;
    //   let SAP = this.state.StartAtPeriodCI;
    //   let EAP = this.state.EndAtPeriodCI;
    //   this.props.handleAdd(SN, DOTW, SAP, EAP);
    // };

    let handleAdd = (clazz) => {
      this.props.handleAdd(clazz);
    };

    let handleRemove = (clazz) => {
      this.props.handleRemove(clazz);
    };

    let item = listClass.map((clazz, index) => {
      return (
        <tr key={index}>
          {/* <td>{clazz.classID}</td> */}
          <td>{clazz.subjectName}</td>
          <td>{clazz.dayOfTheWeek}</td>
          <td>{clazz.startAtPeriod}</td>
          <td>{clazz.endAtPeriod}</td>
          <td>
            {/* viết kiểu như thế này sẽ tạo ra 1 infinite loop!!! */}
            {/* <button type="button" class="btn btn-primary" onClick={handleAdd({ index })}> */}
            <button type="button" class="btn btn-primary" onClick={() => handleAdd(clazz)}>
              ADD
            </button>
          </td>
          <td>
            <button type="button" class="btn btn-danger" onClick={() => handleRemove(clazz)}>
              REMOVE
            </button>
          </td>
        </tr>
      );
    });

    return item;
  }
}

export default ClassInfo;
