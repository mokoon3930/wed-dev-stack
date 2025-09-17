import React from "react";

const InputField = ({ value, placeholder, onChage, errorMessage, type }) => {
  return (
    <div>
      <input
        placeholder={placeholder}
        value={value}
        onChange={onChage}
        type={type}
      />
      <br />
      <div style={{ color: "red" }}>{errorMessage}</div>
    </div>
  );
};

export default InputField;
