import React, { Component } from "react";
import Axios from "axios";
import { connect } from "react-redux";
import ClassInfo from "./ClassInfo";
import $ from "jquery";
import storeReduxUltimate from "../..";

class HomeLogin extends Component {
  constructor(props) {
    super(props);
    this.state = {
      listClass: [],
      // handleAdd & handleRemove parameter
      ClassID: "",
      SubjectName: "",
      DayOfTheWeek: "",
      StartAtPeriod: "",
      EndAtPeriod: "",
      // Monday
      Monday1: "",
      Monday2: "",
      Monday3: "",
      Monday4: "",
      Monday5: "",
      // Tuesday
      Tuesday1: "",
      Tuesday2: "",
      Tuesday3: "",
      Tuesday4: "",
      Tuesday5: "",
      // Wednesday
      Wednesday1: "",
      Wednesday2: "",
      Wednesday3: "",
      Wednesday4: "",
      Wednesday5: "",
      // Thursday
      Thursday1: "",
      Thursday2: "",
      Thursday3: "",
      Thursday4: "",
      Thursday5: "",
      // Friday
      Friday1: "",
      Friday2: "",
      Friday3: "",
      Friday4: "",
      Friday5: "",
    };
  }

  handleAdd = async (clazz) => {
    await this.setState({
      ClassID: clazz.classID,
      SubjectName: clazz.subjectName,
      DayOfTheWeek: clazz.dayOfTheWeek,
      StartAtPeriod: clazz.startAtPeriod,
      EndAtPeriod: clazz.endAtPeriod,
    });

    await this.addStudentClass();
  };

  handleRemove = async (clazz) => {
    await this.setState({
      ClassID: clazz.classID,
    });

    await this.deleteStudentClass();
  };

  async componentDidMount() {
    await this.getListClass();
    await this.getListStudentClassByStudentID();
  }

  addStudentClass = async () => {
    var ClassIDState = this.state.ClassID;
    var SubjectNameState = this.state.SubjectName;
    var DayOfTheWeekState = this.state.DayOfTheWeek;
    var StartAtPeriodState = this.state.StartAtPeriod;
    var EndAtPeriodStatePlusOne = this.state.EndAtPeriod + 1;
    for (let index = StartAtPeriodState; index < EndAtPeriodStatePlusOne; index++) {
      var TimeOnSheduleTable_Z = DayOfTheWeekState.toString() + index.toString();
      // if (this.state[TimeOnSheduleTable_Z] != "") {
      //   alert("Trùng Lịch (hoặc Môn Học Này đã được Đăng Ký) - Thêm Môn Học Thất Bại");
      //   return;
      // }

      if (this.state[TimeOnSheduleTable_Z] != "") {
        if (this.state[TimeOnSheduleTable_Z] == SubjectNameState) {
          alert("Môn Học Này Đã Được Thêm Vào Thời Khóa Biểu Từ Trước");
        } else {
          alert("Trùng Lịch Với Môn Học Khác - Thêm Môn Học Thất Bại");
        }
        return;
      }
    }

    let createStudentClass = {
      studentID: this.props.STUDENTID.idStudent,
      classID: ClassIDState,
    };

    await Axios.post("http://localhost:8083/api/v1/studentclass", createStudentClass, {
      auth: {
        username: this.props.BasicAuth.email,
        password: this.props.BasicAuth.password,
      },
    }).catch((error) => {
      console.log("ERROR: ", error);
      alert("Lỗi");
    });

    for (let index = StartAtPeriodState; index < EndAtPeriodStatePlusOne; index++) {
      var TimeOnSheduleTable_Z = DayOfTheWeekState.toString() + index.toString();
      this.setState({
        [TimeOnSheduleTable_Z]: SubjectNameState,
      });
    }
  };

  deleteStudentClass = async () => {
    let url = "http://localhost:8083/api/v1/studentclass/" + this.props.STUDENTID.idStudent.toString() + "/" + this.state.ClassID.toString();

    // get Axios
    await Axios.get(url, {
      auth: {
        username: this.props.BasicAuth.email,
        password: this.props.BasicAuth.password,
      },
    })
      .then(async (response) => {
        var studentClassInfo = response.data;
        var WeekDayInfo = studentClassInfo.dayOfTheWeek;
        var StartPeriodInfo = studentClassInfo.startAtPeriod;
        var EndPeriodPlusOne = studentClassInfo.endAtPeriod + 1;
        for (let index = StartPeriodInfo; index < EndPeriodPlusOne; index++) {
          var TimeOnSheduleTableInfo = WeekDayInfo.toString() + index.toString();
          this.setState({
            //
            [TimeOnSheduleTableInfo]: "",
          });
        }
      })
      .catch((error) => {
        console.log("ERROR: ", error);
      });

    // delete Axios
    await Axios.delete(url, {
      auth: {
        username: this.props.BasicAuth.email,
        password: this.props.BasicAuth.password,
      },
    });
  };

  getListClass = () => {
    Axios.get("http://localhost:8083/api/v1/clazzs", {
      auth: {
        username: this.props.BasicAuth.email,
        password: this.props.BasicAuth.password,
      },
    })
      .then(async (response) => {
        console.log("response: ", response);

        let listClassAPI = response.data;

        console.log("listClassAPI: ", listClassAPI);

        let listClazz = [];

        console.log("Foreach");

        listClassAPI.forEach((clazzAPI) => {
          let clazz = {
            classID: clazzAPI.classID,
            subjectName: clazzAPI.subjectName,
            dayOfTheWeek: clazzAPI.dayOfTheWeek,
            startAtPeriod: clazzAPI.startAtPeriod,
            endAtPeriod: clazzAPI.endAtPeriod,
          };
          listClazz.push(clazz);
        });
        await this.setState({
          listClass: listClazz,
        });
      })

      .catch((error) => {
        console.log("ERROR: ", error);
      });
  };

  getListStudentClassByStudentID = () => {
    let url = "http://localhost:8083/api/v1/studentclass/" + this.props.STUDENTID.idStudent.toString();
    Axios.get(url, {
      auth: {
        username: this.props.BasicAuth.email,
        password: this.props.BasicAuth.password,
      },
    })
      .then(async (response) => {
        let listStudentClassByStudentID_API = response.data;
        listStudentClassByStudentID_API.forEach((studentClass) => {
          var WeekDay = studentClass.dayOfTheWeek;
          var StartPeriod = studentClass.startAtPeriod;
          var EndPeriodPlusOne = studentClass.endAtPeriod + 1;
          var NameSubject = studentClass.subjectName;
          for (let index = StartPeriod; index < EndPeriodPlusOne; index++) {
            var TimeOnSheduleTable = WeekDay.toString() + index.toString();
            console.log("TimeOnSheduleTable: ", TimeOnSheduleTable);
            this.setState({
              [TimeOnSheduleTable]: NameSubject,
            });
          }
        });
      })

      .catch((error) => {
        console.log("ERROR: ", error);
      });
  };

  render() {
    return (
      <div class="container">
        {/* Danh sách các lớp học */}
        <h2 class="titleList" id="RegistrationList">
          danh sách các lớp học có thể đăng ký
        </h2>
        <br />
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
          <table class="table table-hover">
            <thead>
              <tr>
                <th id="tmh">Tên môn học</th>
                <th id="ntt">Ngày trong tuần</th>
                <th id="tbd">Tiết bắt đầu</th>
                <th id="tkt">Tiết kết thúc</th>
                <th id="addButton">Add To Time Table</th>
                <th id="removeButton">Remove From Time Table</th>
              </tr>
            </thead>
            <tbody>
              <ClassInfo listClass={this.state.listClass} handleAdd={this.handleAdd} handleRemove={this.handleRemove} />
            </tbody>
          </table>
        </div>
        {/* Thời khóa biểu */}
        <br />
        <br />
        <br />
        <div>
          <h2 class="titleList" id="timeTable">
            Thời khóa biểu
          </h2>
        </div>
        <br />
        <table class="table table-hover">
          <thead>
            <tr>
              <th id="time">TIME</th>
              <th id="Monday">MONDAY</th>
              <th id="Tuesday">TUESDAY</th>
              <th id="Wednesday">WEDNESDAY</th>
              <th id="Thursday">THURSDAY</th>
              <th id="Friday">FRIDAY</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td id="period">1st Period</td>
              <td>{this.state.Monday1}</td>
              <td>{this.state.Tuesday1}</td>
              <td>{this.state.Wednesday1}</td>
              <td>{this.state.Thursday1}</td>
              <td>{this.state.Friday1}</td>
            </tr>
            <tr>
              <td id="period">2nd Period</td>
              <td>{this.state.Monday2}</td>
              <td>{this.state.Tuesday2}</td>
              <td>{this.state.Wednesday2}</td>
              <td>{this.state.Thursday2}</td>
              <td>{this.state.Friday2}</td>
            </tr>
            <tr>
              <td id="period">3rd Period</td>
              <td>{this.state.Monday3}</td>
              <td>{this.state.Tuesday3}</td>
              <td>{this.state.Wednesday3}</td>
              <td>{this.state.Thursday3}</td>
              <td>{this.state.Friday3}</td>
            </tr>
            <tr>
              <td id="period">4th Period</td>
              <td>{this.state.Monday4}</td>
              <td>{this.state.Tuesday4}</td>
              <td>{this.state.Wednesday4}</td>
              <td>{this.state.Thursday4}</td>
              <td>{this.state.Friday4}</td>
            </tr>
            <tr>
              <td id="period">5th Period</td>
              <td>{this.state.Monday5}</td>
              <td>{this.state.Tuesday5}</td>
              <td>{this.state.Wednesday5}</td>
              <td>{this.state.Thursday5}</td>
              <td>{this.state.Friday5}</td>
            </tr>
          </tbody>
        </table>
      </div>
    );
  }
}

let mapStateToProps = (state) => {
  return {
    BasicAuth: state.Reducer,
    STUDENTID: state.Reducer,
  };
};

export default connect(mapStateToProps, null)(HomeLogin);
