import React, {Fragment} from "react";
import ReactDOM from 'react-dom';
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import { Grid,Form,Button, Input, Segment } from 'semantic-ui-react'
import Navbar from "./component/Navbar.jsx";
import '../resources/css/Add_table.css';
import jQuery from 'jquery';
window.$ = window.jQuery = jQuery;
 
class Add_table extends React.Component {
    constructor(props) {
        super(props);
        this.state = { 
          table_title:"",
          table_text: ""
        }
      };
    
      _addTable = (e) => {
        const { table_title,table_text } = this.state;
        e.preventDefault();

        $.get('/table/insert'),
        {
            table_title : table_title,
            table_text : table_text
        },
        function(){
            alert("등록 되었습니다!");
        }
    }
      
      _titleUpdate(e) {
        this.setState({ table_title : e.target.value })
      }
      _textUpdate(data) {
        this.setState({ table_text: data })
      }
    render() {
        console.log("title", )
        return (
            <Fragment>
                <Navbar/>
                <Grid id="mylayoutAdd_table">
                    <Grid.Column className="addtableClm">
                    <Form onSubmit={this._addTable} >
                    <Form.Field required>
                        <label>제목</label>
                        <Input placeholder='제목' onChange={(e) => this._titleUpdate(e)}/>
                    </Form.Field>
                    <CKEditor style={{ minWidth: "60vw"}}
                            editor={ ClassicEditor }
                            onReady={ editor => {
                                // You can store the "editor" and use when it is needed.
                                console.log( 'Editor is ready to use!', editor );
                            } }
                            onChange={ ( event, editor ) => {
                                const data = editor.getData();
                                this._textUpdate(data);
                                console.log( { event, editor, data } );
                            } }
                            onBlur={ ( event, editor ) => {
                                console.log( 'Blur.', editor );
                            } }
                            onFocus={ ( event, editor ) => {
                                console.log( 'Focus.', editor );
                            } }
                        />
                        <Segment textAlign='center' className="addbtnSegment">
                            <Button fluid type="submit" size='huge' color='blue' id='requstionButton'>
                            등록
                            </Button>
                        </Segment>
                    </Form>
                    </Grid.Column>
                </Grid>
            </Fragment>
        )
    }
 
}
 
ReactDOM.render(<Add_table/>, document.getElementById('root'));