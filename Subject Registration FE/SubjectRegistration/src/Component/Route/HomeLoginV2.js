import React, { Component } from "react";
import Axios from "axios";
import { connect } from "react-redux";
import ClassInfo from "./ClassInfo";

class HomeLoginV2 extends Component {
  constructor(props) {
    super(props);
    this.state = {
      listClass: [],
    };
  }

  getListClass = () => {
    Axios.get("http://localhost:8083/api/v1/clazzs?sort=classID,asc", {
      auth: {
        username: this.props.BasicAuth.email,
        password: this.props.BasicAuth.password,
      },
    })
      .then((response) => {
        console.log("response: ", response);

        let listClassAPI = response.data;

        console.log("listClassAPI: ", listClassAPI);

        let listClazz = [];

        console.log("Foreach");

        listClassAPI.forEach((clazzAPI) => {
          let clazz = {
            SubjectName: clazzAPI.subjectName,
            DayOfTheWeek: clazzAPI.dayOfTheWeek,
            StartAtPeriod: clazzAPI.startAtPeriod,
            EndAtPeriod: clazzAPI.endAtPeriod,
          };
          listClazz.push(clazz);
        });
        this.setState({
          listClass: listClazz,
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
        <h2 class="titleList">danh sách các lớp học có thể đăng ký</h2>
        <br />
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
          <table class="table table-hover">
            <thead>
              <tr>
                <th>Tên môn học</th>
                <th>Ngày trong tuần</th>
                <th>Tiết bắt đầu</th>
                <th>Tiết kết thúc</th>
                <th>ADD</th>
                <th>REMOVE</th>
              </tr>
            </thead>
            <tbody>
              <ClassInfo listClass={listClass} />
            </tbody>
          </table>
        </div>
        {/* Thời khóa biểu */}
        <br />
        <br />
        <div>
          <h2 class="titleList">Thời khóa biểu</h2>
        </div>
        <br />
        <br />
        <div>
          <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
            <form action="" method="POST" role="form">
              <legend>Tiết / Thứ</legend>
              <div class="form-group">
                <input disabled={true} class="form-control" value={1} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" value={2} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" value={3} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" value={4} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" value={5} />
              </div>
            </form>
          </div>
          <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
            <form action="" method="POST" role="form">
              <legend>Monday</legend>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Monday1" value={""} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Monday2" value={""} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Monday3" value={""} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Monday4" value={""} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Monday5" value={""} />
              </div>
            </form>
          </div>
          <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
            <form action="" method="POST" role="form">
              <legend>Tuesday</legend>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Tuesday1" value={""} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Tuesday2" value={""} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Tuesday3" value={""} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Tuesday4" value={""} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Tuesday5" value={""} />
              </div>
            </form>
          </div>
          <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
            <form action="" method="POST" role="form">
              <legend>Wednesday</legend>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Wednesday1" value={""} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Wednesday2" value={""} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Wednesday3" value={""} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Wednesday4" value={""} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Wednesday5" value={""} />
              </div>
            </form>
          </div>
          <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
            <form action="" method="POST" role="form">
              <legend>Thursday</legend>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Thursday1" value={""} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Thursday2" value={""} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Thursday3" value={""} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Thursday4" value={""} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Thursday5" value={""} />
              </div>
            </form>
          </div>
          <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
            <form action="" method="POST" role="form">
              <legend>Friday</legend>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Friday1" value={""} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Friday2" value={""} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Friday3" value={""} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Friday4" value={""} />
              </div>
              <div class="form-group">
                <input disabled={true} class="form-control" name="Friday5" value={""} />
              </div>
            </form>
          </div>
        </div>
      </div>
    );
  }
}

let mapStateToProps = (state) => {
  return {
    BasicAuth: state.Reducer,
  };
};

export default connect(mapStateToProps, null)(HomeLoginV2);
