import React, { Component } from "react";

class Test extends Component {
  constructor(props) {
    super(props);
    this.state = {
      Monday100: "Monday100",
    };
  }

  render() {
    let day = "Monday";
    let number = "100";
    let dayAndNumber = day + number;

    return (
      <div>
        {/* I Want To Do It Like This */}
        {/* {this.state.dayAndNumber} */}
        {/* Original Way */}
        {this.state.Monday100}
      </div>
    );
  }
}

export default Test;
