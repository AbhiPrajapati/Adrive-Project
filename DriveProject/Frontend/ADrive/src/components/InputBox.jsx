import '../index.css'


function InputBox(props){
    return (
        <div className='input-div'>
           <input type={props.type} placeholder={props.placeholder} className={props.className} />
        </div>
    );
}

export default InputBox;